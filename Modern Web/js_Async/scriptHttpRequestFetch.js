const sectionNotes = document.querySelector("#notas");
const newNote = document.querySelector("#novaNota");
const urlRequest = "https://fiap-notes-api.herokuapp.com/notes";

const addNotes = (notas = []) => {
  notas.forEach((nota) => {
    const p = document.createElement("p");
    p.innerHTML = nota.text;
    sectionNotes.appendChild(p);
  });
};

const xmlHttp = new XMLHttpRequest();
xmlHttp.open("GET", "https://fiap-notes-api.herokuapp.com/notes");
xmlHttp.responseType = "json";

xmlHttp.onLoad = () => {
  addNotes(xmlHttp.response);
};

const getNotes = () => {
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

const createNote = (event) => {
  event.preventDefault();

  const body = JSON.stringify({ text: newNote.value });

  fetch(urlRequest, {
    method: "POST",
    body,
    headers: {
      "Content-type": "application/json",
    },
  })
    .then((respons) => respons.json())
    .then((json) => {
      addNotes([json]);
      event.target.reset();
    });
};

getNotes();
