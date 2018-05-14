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
"=" {return ASSIGN;}
"+" {return SUMA;}
"*" {return MULT;}
"-" {return RESTA;}
"/" {return DIV;} 
{L}({L}|{D})* {lexema=yytext();
                System.out.println("Codigo");
                return ID;}
 ("(-"{D}+")")|{D}+ {lexema=yytext(); return INT;}
. {return ERROR;}