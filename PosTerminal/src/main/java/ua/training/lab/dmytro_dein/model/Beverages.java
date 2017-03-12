package ua.training.lab.dmytro_dein.model;


public enum Beverages {
    TEA(1), COFFEE(2), JUICE(3), EXIT(0), UNDEFINED(Integer.MAX_VALUE);

    private int choose;

    public static Beverages mapFromInt(int value){
        for(Beverages ch: values()){
            if(ch.getChoose() == value){
                return ch;
            }
        }
        return UNDEFINED;
    }

    Beverages(int choose) {
        this.choose = choose;
    }

    int getChoose(){
        return choose;
    }
}
