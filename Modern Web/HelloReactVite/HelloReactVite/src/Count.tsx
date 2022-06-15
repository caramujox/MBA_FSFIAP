import { useState } from "react";
import styled from "styled-components";

const Button = styled.button`
    background-Color: blue;
`;

function Count() {
    const [count, setCount] = useState(0);

    // const handleIncrement = () => {
    //     setCount(count+1);
    // }
    // Pega o valor no MOMENTO que o setState foi chamado

    const handleIncrement = () => {
        setTimeout(() => {
            setCount(prevState => prevState + 1);
        }, 1000)
    }

    return (
        <div>{count}{" "}
        <Button onClick={handleIncrement}>+</Button>
        </div>
    )
}

export default Count;