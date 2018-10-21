/**
 * Programa sencillo para ejercicios de subneteo de redes.
 * @author (Lilo) 
 * @version (1.0.0)
 */
public class subnet
{
    private boolean dentroDeLos255(int numero)
    {
        return (numero > -1 && numero < 256);
    }

    private static int dosElevado(int exp)
    {
        int num = 1;
        if(exp > 0){
            for(int i = 0;i < exp;i++){
                num=num*2;
            }
        }else{return 0;}
        return  num;
    }

    private int devolverExponente(int numero)
    {
        for(int i = 2;i < 33;i++){
            if((numero+2) <= dosElevado(i))
            {
                return i;
            }
        }
        return 0;
    }

    private int devuelveOcteto(int numero)
    {
        if(numero<=8)return 4;
        if(numero<=16)return 3;
        if(numero<=24)return 2;
        return 1;
    }

    private int regresaNumeroDependiendoDelOcteto(int numero)
    {
        int exponente = devolverExponente(numero);
        if(devuelveOcteto(exponente)==1)return exponente-24;
        if(devuelveOcteto(exponente)==2)return exponente-16;
        if(devuelveOcteto(exponente)==3)return exponente-8;
        return exponente;
    }

    private String mascara(int numero)
    {
        int exponente = devolverExponente(numero);
        int octeto = devuelveOcteto(exponente);
        int exponenteEnOcteto = regresaNumeroDependiendoDelOcteto(numero);
        int resta = 0;
        int aux = 128;
        for(int i = 0;i < (8 - exponenteEnOcteto);i++)
        {
            resta+=aux;
            aux-=(aux/2);
        }
        String mascaraRed = "";
        boolean bandera = false;  
        for(int i = 0;i < 4;i++)
        {
            if(i+1 == octeto)
            {
                if(i==0)
                {
                    mascaraRed+=""+resta;
                }else{
                    mascaraRed+="."+resta;
                }

                bandera = true;
            }else{
                if(bandera)
                {
                    mascaraRed+= "."+0;
                }else{
                    mascaraRed+= (i==0)? "255" : ("."+255);
                }
            }
        }
        return mascaraRed;
    }

    private String rango(String ip,String mascara,int numero)
    {
        int exponente = devolverExponente(numero);
        int octeto = devuelveOcteto(exponente);
        String[] oct = mascara.split("\\.");
        int saltos = 256 - Integer.parseInt(oct[octeto-1]);
        return "Saltos de -> "+saltos;
    }

    public static void main(String [] args)
    {
        subnet s = new subnet();
        /*System.out.println("mascara de 20 -> "+s.devolverExponente(20)+" -> "+s.mascara(20));
        System.out.println("mascara de 32 -> "+s.devolverExponente(32)+" -> "+s.mascara(32));
        System.out.println("mascara de 64 -> "+s.devolverExponente(64)+" -> "+s.mascara(64));
        System.out.println("mascara de 128 -> "+s.devolverExponente(128)+" -> "+s.mascara(128));
        System.out.println("mascara de 256 -> "+s.devolverExponente(255)+" -> "+s.mascara(255));
        System.out.println("mascara de 512 -> "+s.devolverExponente(511)+" -> "+s.mascara(511));
        System.out.println("mascara de 1028 -> "+s.devolverExponente(1028)+" -> "+s.mascara(1028));
        System.out.println("mascara de 8000 -> "+s.devolverExponente(8000)+" -> "+s.mascara(8000));
        System.out.println("mascara de 80000 -> "+s.devolverExponente(80000)+" -> "+s.mascara(80000));
        System.out.println("mascara de 800000 -> "+s.devolverExponente(800000)+" -> "+s.mascara(800000));
        System.out.println("mascara de 10000000 -> "+s.devolverExponente(10000000)+" -> "+s.mascara(10000000));
        System.out.println("mascara de 536870910 -> "+s.devolverExponente(536870912)+" -> "+s.mascara(536870912));
        System.out.println("mascara de 999999999 -> "+s.devolverExponente(999999999)+" -> "+s.mascara(999999999));

        System.out.println(s.rango("18.0.0.0,",s.mascara(20),20));
        System.out.println(s.rango("18.0.0.0,",s.mascara(32),32));
        System.out.println(s.rango("18.0.0.0,",s.mascara(64),64));
        System.out.println(s.rango("18.0.0.0,",s.mascara(128),128));
        System.out.println(s.rango("18.0.0.0,",s.mascara(256),256));
        System.out.println(s.rango("18.0.0.0,",s.mascara(512),512));
        System.out.println(s.rango("18.0.0.0,",s.mascara(1208),1208));
        System.out.println(s.rango("18.0.0.0,",s.mascara(8000),8000));
        System.out.println(s.rango("18.0.0.0,",s.mascara(80000),80000));
        System.out.println(s.rango("18.0.0.0,",s.mascara(800000),800000));
        System.out.println(s.rango("18.0.0.0,",s.mascara(10000000),10000000));
        System.out.println(s.rango("18.0.0.0,",s.mascara(536870910),536870910));
        System.out.println(s.rango("18.0.0.0,",s.mascara(999999999),999999999));*/
        
        System.out.println("mascara de 2 -> "+s.devolverExponente(2)+" -> "+s.mascara(2)+" => "+s.rango("5.250.0.4",s.mascara(2),2));
        System.out.println("mascara de 25 -> "+s.devolverExponente(25)+" -> "+s.mascara(25)+" => "+s.rango("5.250.0.4",s.mascara(25),25));
        System.out.println("mascara de 32 -> "+s.devolverExponente(32)+" -> "+s.mascara(32)+" => "+s.rango("5.250.0.4",s.mascara(32),32));
        System.out.println("mascara de 45 -> "+s.devolverExponente(45)+" -> "+s.mascara(45)+" => "+s.rango("5.250.0.4",s.mascara(45),45));
        System.out.println("mascara de 98 -> "+s.devolverExponente(98)+" -> "+s.mascara(98)+" => "+s.rango("5.250.0.4",s.mascara(98),98));
        System.out.println("mascara de 280 -> "+s.devolverExponente(280)+" -> "+s.mascara(280)+" => "+s.rango("5.250.0.4",s.mascara(280),280));
        System.out.println("mascara de 145 -> "+s.devolverExponente(145)+" -> "+s.mascara(145)+" => "+s.rango("5.250.0.4",s.mascara(145),145));
        System.out.println("mascara de 450 -> "+s.devolverExponente(450)+" -> "+s.mascara(450)+" => "+s.rango("5.250.0.4",s.mascara(450),450));
        System.out.println("mascara de 800 -> "+s.devolverExponente(800)+" -> "+s.mascara(800)+" => "+s.rango("5.250.0.4",s.mascara(800),800));
        System.out.println("mascara de 670 -> "+s.devolverExponente(670)+" -> "+s.mascara(670)+" => "+s.rango("5.250.0.4",s.mascara(670),670));
        System.out.println("mascara de 3500 -> "+s.devolverExponente(3500)+" -> "+s.mascara(3500)+" => "+s.rango("5.250.0.4",s.mascara(3500),3500));
        System.out.println("mascara de 6100 -> "+s.devolverExponente(6100)+" -> "+s.mascara(6100)+" => "+s.rango("5.250.0.4",s.mascara(6100),6100));
        System.out.println("mascara de 7000 -> "+s.devolverExponente(7000)+" -> "+s.mascara(7000)+" => "+s.rango("5.250.0.4",s.mascara(7000),7000));
    }
}
