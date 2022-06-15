import { PropsWithChildren } from "react";

interface ButtonProps {
    text: string;
    type?: string;
    handleClick?: () => void ;

    children: React.ReactNode;
}

// Outra forma de declarar as propriedades de um componente
// function Button(props: ButtonProps) {
//     return (
//         <button>{props.text}</button>
//     )
// }

function Button({text,children}: ButtonProps) {
    return (
        <button>{children}</button>
    )
}

export default Button;