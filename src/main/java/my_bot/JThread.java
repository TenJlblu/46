package my_bot;

class JThread extends Thread{

    private Runnable item;

    JThread(String name, Runnable item){
        super(name);
        this.item = item;;
        start();
    }

    public void run(){
        try {
            item.run();
            Thread.sleep(500);
        } catch(InterruptedException e) {
            return;
        }
    }
}