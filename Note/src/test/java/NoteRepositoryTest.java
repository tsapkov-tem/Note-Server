import com.example.note.Entity.Notes.Notes;
import com.example.note.Repository.NotesRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@ComponentScan(basePackages = {"com.example.note"})
@EnableAutoConfiguration
@Import(NotesRepository.class)
public class NoteRepositoryTest {

    @Autowired
    private NotesRepository notesRepository;


    @Test
    public void testSave(){
        Notes note = new Notes();
        note.setIdNote(1);
        note.setHeading("head");
        note.setDateChange(Date.valueOf("20-10-1999"));
        note.setDateCreation(Date.valueOf("20-10-1999"));
        note.setIdUser(0);
        note.setText("text");
        Notes newNote = notesRepository.save(note);
        Assertions.assertThat(newNote).isNotNull();
        Assertions.assertThat(newNote.getIdUser()).isGreaterThan(0);
    }

    @Test
    public void testFindById(){
        Notes note = new Notes();
        note.setIdNote(1);
        note.setHeading("head");
        note.setDateChange(Date.valueOf("20-10-1999"));
        note.setDateCreation(Date.valueOf("20-10-1999"));
        note.setIdUser(0);
        note.setText("text");
        Notes idNote = notesRepository.findById(1).orElse(null);
        Assertions.assertThat(idNote).isNotNull();
    }
    @Test
    public void testFindByUserId(){
        Notes note = new Notes();
        note.setIdNote(1);
        note.setHeading("head");
        note.setDateChange(Date.valueOf("20-10-1999"));
        note.setDateCreation(Date.valueOf("20-10-1999"));
        note.setIdUser(0);
        note.setText("text");
        List<Notes> idNote = notesRepository.getAllByIdUser(1);
        Assertions.assertThat(idNote).isNotNull();
    }

}

