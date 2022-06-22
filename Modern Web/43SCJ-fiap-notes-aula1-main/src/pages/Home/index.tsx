import { useEffect, useState } from "react";
import CardNote from "../../components/CardNote";
import FabButton from "../../components/FabButton";
import FormNote from "./FormNote";
import Modal from "../../components/Modal";
import { NotesService } from "../../services/notes/note-service";
import { Note } from "../../services/notes/types";
import { Container } from "./styles";
import { api } from "../../services/api";

function Home() {
  const [notes, setNotes] = useState<Note[]>([]);
  const [showModal, setShowModal] = useState<Modal>();

  useEffect(() => {
    (async () => {
     const response = await api.get("/notes");

     setNotes(response.data);
    })();
  }, []);

  const handleUpdateNewNotes = (note: Note) => {
    setNotes([...notes, note]);
    setShowModal(false);
  }

  return (
    <>
      {showModal && (<Modal title="Nova nota" handleClose={() => setShowModal(false)}>
        <FormNote
        handleUpdateNotes={(handleUpdateNewNotes)}/>
      </Modal>)}
      <Container>
        {notes.map((note) => (
          <CardNote key ={note.id} note={note}></CardNote>
        ))}
        <FabButton handleClick={() => setShowModal(true)}>+</FabButton>
      </Container>
    </>
  );
}

export default Home;
