public class esercizio_a_casa_01 
{
    public static void main(String[] args)
    {
        //Prova con ciclo for 

        String[] alunno = {"Greta","Tiziano","Emanuele","Cristopher","Giorgio","Simone","Alessandro","Andrea","Davide","Gianluca"};
        int dimensione = alunno.length;
        for(int i = 0; i < dimensione; i++)
        {
            System.out.println(alunno[i]);

        }
        System.out.println("\nPausa\n");
        
        //Prova con ciclo for each

        for (String stud : alunno)
        {
            System.out.println(stud);

        }
    }
}