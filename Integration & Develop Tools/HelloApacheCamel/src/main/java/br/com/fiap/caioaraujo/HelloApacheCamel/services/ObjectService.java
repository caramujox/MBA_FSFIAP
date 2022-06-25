package br.com.fiap.caioaraujo.HelloApacheCamel.services;


import br.com.fiap.caioaraujo.HelloApacheCamel.beans.MyObject;

public abstract class ObjectService {


    public static void execute (MyObject object){
        object.setName("Preenchendo o nome do Object");
        object.setId(object.getId()*10);
    }
}
