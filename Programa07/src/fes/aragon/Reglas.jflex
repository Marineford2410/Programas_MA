package fes.aragon;
import static fes.aragon.Tokens;
%%
%class Lexico
%type Tokens
L = [a-zA-Z_]
D = [0-9]
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%%
{WHITE} {/*Ignore*/}

"(" {return PARENTIZQ;}
")" {return PARENTDER;}
"true" {return TRUE;}
"TRUE" {return TRUE2;}
"false" {return FALSE;}
"FALSE" {return FALSE2;}
"not" {return NOT;}
"NOT" {return NOT2;}
"and" {return AND;}
"AND" {return AND2;}
"or" {return OR;}
"OR" {return OR2;}
"si" {return SI;}
"SI" {return SI2;}
"sii" {return SII;}
"SII" {return SII2;}



. {return ERROR;}