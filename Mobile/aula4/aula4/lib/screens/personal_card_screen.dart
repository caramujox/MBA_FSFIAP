import 'package:aula4/components/rounded_button.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class PersonalCardScreen extends StatelessWidget {
  static const id = 'personal_card_screen';

  final PersonalCardScreenArgs arguments;
  const PersonalCardScreen({Key? key, required this.arguments})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: Colors.indigo,
        body: SafeArea(
          child: Container(
            width: double.infinity,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  decoration: BoxDecoration(shape: BoxShape.circle),
                  child: CircleAvatar(
                    radius: 100,
                    backgroundImage: NetworkImage(arguments.image),
                  ),
                ),
                Text(
                  'Become what you must',
                  style: GoogleFonts.lato(
                      fontSize: 26,
                      color: Colors.white,
                      fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 10),
                Text(
                  arguments.name,
                  style: GoogleFonts.lato(
                      fontSize: 26,
                      color: Colors.white,
                      fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 10),
                Text(
                  arguments.phone,
                  style: GoogleFonts.lato(
                      fontSize: 26,
                      color: Colors.white,
                      fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 10),
                Text(
                  arguments.email,
                  style: GoogleFonts.lato(
                      fontSize: 26,
                      color: Colors.white,
                      fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 10),
              ],
            ),
          ),
        ));
  }
}

class PersonalCardScreenArgs {
  const PersonalCardScreenArgs(
      {required this.image,
      required this.name,
      required this.phone,
      required this.email});

  final String image;
  final String email;
  final String phone;
  final String name;
}
