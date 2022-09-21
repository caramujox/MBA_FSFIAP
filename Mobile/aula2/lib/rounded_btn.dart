import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';


class RoundedBtn extends StatelessWidget{
  const RoundedBtn({super.key, required this.text, required this.icon, required this.onTap});

  final String text;
  final Icon icon;
  final Function() onTap;

  @override
  Widget build(BuildContext context) {
    return                 Padding(
      padding: const EdgeInsets.symmetric(horizontal: 10.0),
      child: SizedBox(
        child:
        ListTile(
          shape: RoundedRectangleBorder(
              borderRadius: BorderRadius.all(Radius.circular(16))),
          leading: icon,
          title: Text(
            text,
            style: GoogleFonts.lato(
                fontSize: 26,
                color: Colors.white,
                fontWeight: FontWeight.bold),
          ),
          tileColor: Colors.red,
          onTap: onTap,
        ),
      ),
    );

  }

}