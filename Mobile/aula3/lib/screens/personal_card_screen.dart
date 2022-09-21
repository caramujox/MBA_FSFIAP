import 'package:aula3/components/rounded_button.dart';
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';

class PersonalCardScreen extends StatelessWidget {
  static const id = 'personal_card_screen';
  const PersonalCardScreen({Key? key}) : super(key: key);

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
                    backgroundImage: NetworkImage(
                        'http://cdn1.dotesports.com/wp-content/uploads/2021/12/13041818/ffxiv_11122021_220456_350.png'),
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
                SizedBox(height: 10),
              ],
            ),
          ),
        ));
  }
}
