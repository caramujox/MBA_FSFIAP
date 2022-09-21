import 'package:aula3/components/rounded_button.dart';
import 'package:aula3/screens/personal_card_screen.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class MenuScreen extends StatelessWidget {
  static const String id = 'menu_screen';
  const MenuScreen({Key? key}) : super(key: key);



  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
                      Text("Menu Inicial", style: GoogleFonts.lato(
                        textStyle:
                        TextStyle(
                          fontSize: 30
                        )
                      )),
            SizedBox(height: 16,),
            RoundedBtn(text: "Cartão Pessoal", onTap: (){
              print("cliquei no botao");
              Navigator.pushNamed(context, PersonalCardScreen.id);
            })
          ]
        ),
      ),
    );
  }
}
