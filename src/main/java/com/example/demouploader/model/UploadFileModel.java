package com.example.demouploader.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class UploadFileModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private Long id;
    private String name;
    private String type;

    @Lob
    private byte[] context;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UploadFileModel that = (UploadFileModel) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 1489010943;
    }
}
