package com.example.note.Entity.Notes;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Audited
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Notes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_note")
    private Integer idNote;
    @Basic
    @Column(name = "id_user", nullable = false)
    private Integer idUser;
    @Basic
    @Column(name = "heading", nullable = false, length = 100)
    private String heading;
    @Basic
    @Column(name = "date_creation", nullable = false)
    private Date dateCreation;
    @Basic
    @Column(name = "date_change", nullable = false)
    private Date dateChange;
    @Basic
    @Column(name = "text", nullable = true, length = -1)
    private String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Notes notes = (Notes) o;
        return idNote != null && Objects.equals(idNote, notes.idNote);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
