package fes.aragon;
import static fes.aragon.Tokens;
%%
%class Lexico
%type Tokens
WHITE=[ \t\r\n]
%{
public String lexema;
%}
%%
{WHITE} {/*Ignore*/}
"a" {return A;}
"b" {return B;}
"c" {return C;}
";" {return PUNTOYCOMA;}

. {return ERROR;}