import { useState } from "react";

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
        <button onClick={handleIncrement}>+</button>
        </div>
    )
}

export default Count;