package com.izu.hatavar.models;

import javax.persistence.*;

@Entity
@Table(name = "records")
public class Bug
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private String title;

    @ManyToOne//(cascade = CascadeType.ALL) //default fetch type is EAGER which means it will also fetch the related object, user in this case
    @JoinColumn(name = "user_id", nullable = false)

    private User user;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

}
