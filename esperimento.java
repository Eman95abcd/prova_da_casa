public class esperimento {
    public static void main(String[] args)
    {
        String[] alunno = {"Greta","Tiziano","Emanuele","Cristopher","Giorgio","Simone","Alessandro","Andrea","Davide","Gianluca"};
        int dimensione = alunno.length;
        for(int i = 0; i < dimensione; i++)
        {
            System.out.println(alunno[i]);
            if (alunno[i]=="Tiziano")
            {
                System.out.print("é sempre in ritardo\n");
            }
            else if (alunno[i]=="Giorgio")
            {
                System.out.print("é in pausa\n");
            }
            else if (alunno[i]=="Gianluca")
            {
                System.out.print("é in Giappone\n");
            }
            
        }
    }
    
}
