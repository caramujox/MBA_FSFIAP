const sectionNotes = document.querySelector("#notas");

const addNotes = (notas = []) => {
  notas.forEach((nota) => {
    const p = document.createElement("p");
    p.innerHTML = nota.text;
    sectionNotes.appendChild(p);
  });
};

const doRequestAjax = () => {
  return new Promise((resolve, reject) => {
    const xmlHttp = new XMLHttpRequest();
    xmlHttp.open("GET", "https://fiap-notes-api.herokuapp.com/notes");
    xmlHttp.responseType = "json";

    xmlHttp.onload = () => {
      if (xmlHttp.status !== 200) {
        reject("Ops, algo deu errado!");
      } else {
        resolve(xmlHttp.response);
      }
    };

    xmlHttp.onerror = () => {
      reject("Ops, verifique sua conexão");
    };
    xmlHttp.readyState;

    xmlHttp.send();
  });
};

const showError = (err) => {
  const p = document.createElement("p");
  p.textContent = err;
  p.style.color = "red";
  sectionNotes.appendChild(p);
};

doRequestAjax()
  .then((body) => addNotes(body)) // chamada na Resolve
  .catch((error) => alert(error)) // chamada na Reject
  .finally(); // chamada

