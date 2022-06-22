import { useEffect, useState } from "react";
import { api } from "../../services/api";
import { Note } from "../../services/notes/types";
import { FabButtonStyled } from "./styles";

interface FBProps {
  children: React.ReactNode;
  handleClick: () => void;
}

function FabButton({ children, handleClick }: FBProps) {
  // const [notes, setNotes] = useState<Note[]>([]);
  // useEffect(() => {
  //   (async () => {
  //     const response = await api.post("/notes"); 
  //   })()
  // });

  return <FabButtonStyled onClick={handleClick}><p>{children}</p></FabButtonStyled>;
}

export default FabButton;
