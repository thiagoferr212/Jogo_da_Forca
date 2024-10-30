package game;

public class BonecoForca {
    
    private static final String[] estagiosBoneco = {
        """
            ______
            |    |
            |    O
            |   /|\\
            |   / \\
            |
            |
        =========
        """,
        """
            ______
            |    |
            |    O
            |   /|\\
            |   /
            |
            |
        =========
        """,
        """
            ------
            |    |
            |    O
            |   /|\\
            |
            |
            |
        =========
        """,
        """
            ______
            |    |
            |    O
            |   /|
            |
            |
            |
        =========
        """,
        """
            ______
            |    |
            |    O
            |    |
            |
            |
            |
        =========
        """,
        """
            ______
            |    |
            |    O
            |
            |
            |
            |
        =========
        """,
        """
            ______
            |    |
            |
            |
            |
            |
            |
        =========
        """,
   
    };

    public void exibirBoneco(int tentativasRestantes){
        System.out.println(estagiosBoneco[tentativasRestantes]);
    }
    
}
