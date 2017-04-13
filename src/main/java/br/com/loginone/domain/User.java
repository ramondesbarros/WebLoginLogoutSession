package br.com.loginone.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
    
    private static final long serialVersionUID = -6332748512915369097L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private Long idUser;
    
    @Column(name="user_login")
    private String loginUser;
    
    @Column(name="user_password")
    private String passwordUser;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getPasswordUser() {
        return passwordUser;
    }
    
    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [");
        if (idUser != null) {
            builder.append("idUser: ");
            builder.append(idUser);
            builder.append(" | ");
        }
        if (loginUser != null) {
            builder.append("loginUser: ");
            builder.append(loginUser);
            builder.append(" | ");
        }
        if (passwordUser != null) {
            builder.append("passwordUser: ");
            builder.append(passwordUser);
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUser == null) ? 0 : idUser.hashCode());
        result = prime * result + ((loginUser == null) ? 0 : loginUser.hashCode());
        result = prime * result + ((passwordUser == null) ? 0 : passwordUser.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (idUser == null) {
            if (other.idUser != null)
                return false;
        } else if (!idUser.equals(other.idUser))
            return false;
        if (loginUser == null) {
            if (other.loginUser != null)
                return false;
        } else if (!loginUser.equals(other.loginUser))
            return false;
        if (passwordUser == null) {
            if (other.passwordUser != null)
                return false;
        } else if (!passwordUser.equals(other.passwordUser))
            return false;
        return true;
    }
}
