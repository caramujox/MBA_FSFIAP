const sectionNotes = document.querySelector("#notas");
const newNote = document.querySelector("#novaNota");

const addNotes = (notas = []) => {
  notas.forEach((nota) => {
    const p = document.createElement("p");
    p.innerHTML = nota.text;
    sectionNotes.appendChild(p);
  });
};

const getNotes = async () => {
  try {
    fetch("https://fiap-notes-api.herokuapp.com/notes");
    const json = await response.json();

    const resolves = await Promise.all([new Promise(), new Promise()]);

    addNotes(json);
  } catch (err) {
    if (err.response) {
      return alert("Bad Request");
    }
    alert("Verifique a Internet");
  } finally {
    console.log("finalizou");
  }
};

const createNote = async (event) => {
  fetch("https://fiap-notes-api.herokuapp.com/notes")
    .then((response) => response.json())
    .then((json) => addNotes(json))
    .catch((err) => {
      if (err.response) {
        return alert("Bad Request");
      }
      alert("Verifique a Internet");
    });
};

getNotes();
