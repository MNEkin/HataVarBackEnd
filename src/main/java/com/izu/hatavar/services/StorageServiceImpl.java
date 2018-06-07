package com.izu.hatavar.services;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService
{

    private final Path rootLocation = Paths.get("C://HataVarImg");


    @Override
    public String store(MultipartFile[] files)
    {
        UUID uuid = UUID.randomUUID();
        Path uploadDir = Paths.get(rootLocation + "/" + uuid);
        try
        {
            Files.createDirectories(uploadDir);
        }
        catch (IOException e)
        {
            System.out.println("Cannot create upload dir");
        }
        for (MultipartFile file : files)
        {
            String filename = StringUtils.cleanPath(file.getOriginalFilename());
            try
            {
                if (file.isEmpty())
                {
                    return "File is empty";
                }
                if (filename.contains(".."))
                {
                    // This is a security check
                    return "Cannot save outside the current dir";
                }
                try (InputStream inputStream = file.getInputStream())
                {
                    Files.copy(inputStream, this.rootLocation.resolve(filename),
                            StandardCopyOption.REPLACE_EXISTING);
                }
            }
            catch (IOException e)
            {
                return "Failed to store";
            }
        }
        return uploadDir.toString();
    }

    @Override
    public Stream <Path> loadAll() throws IOException
    {
        try
        {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(this.rootLocation::relativize);
        }
        catch (IOException e)
        {
            throw new IOException("exception : " + e);
        }

    }

    @Override
    public Path load(String filename)
    {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) throws Exception
    {
        try
        {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable())
            {
                return resource;
            }
            else
            {
                throw new Exception("Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e)
        {
            throw new MalformedURLException("Could not read file: " + filename + " " + e);
        }
    }

    @Override
    public void deleteAll()
    {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void init() throws IOException
    {
        try
        {
            Files.createDirectories(rootLocation);
        }
        catch (IOException e)
        {
            throw new IOException("Could not initialize storage", e);
        }
    }
}
