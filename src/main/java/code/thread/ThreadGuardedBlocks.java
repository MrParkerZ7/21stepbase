package code.thread;

public class ThreadGuardedBlocks {

    static class StartWindows {
        private boolean energy = false;
        private boolean login = false;
        private boolean windowRun = false;
        private boolean autorun = false;

        public synchronized void setEnergy(boolean energy) {
            this.energy = energy;
            notifyAll();
        }

        public synchronized void setLogin(boolean login) {
            this.login = login;
            notifyAll();
        }

        public synchronized void setWindowRun(boolean windowRun) {
            this.windowRun = windowRun;
            notifyAll();
        }

        public synchronized void setAutorun(boolean autorun) {
            this.autorun = autorun;
            notifyAll();
        }

        private synchronized void inputEnergy() throws InterruptedException {
            System.out.println("Energy: waiting for energy");
            while (!energy)
                wait();
            System.out.println("Energy: imported");
        }

        private synchronized void userLogin() throws InterruptedException {
            System.out.println("Login: waiting for user login");
            while (!login)
                wait();
            System.out.println("Login: successful");
        }

        private synchronized void runWindows() throws InterruptedException {
            System.out.println("Windows: waiting for user login successful");
            while (!windowRun)
                wait();
            System.out.println("Window Started");
        }

        private synchronized void runProgram() throws InterruptedException {
            System.out.println("Program: waiting for user login successful");
            while (!autorun)
                wait();
            System.out.println("Program: running");
        }

        private synchronized void systemReady() throws InterruptedException {
            System.out.println("System: waiting for everything papered");
            while (!windowRun && !autorun)
                wait();
            System.out.println("System: ready!!");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        StartWindows start = new StartWindows();

        Thread powerOn = new Thread(() -> {
            try {
                start.inputEnergy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread userLoggin = new Thread(() -> {
            try {
                start.userLogin();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread runWindows = new Thread(() -> {
            try {
                start.runWindows();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread runProgram = new Thread(() -> {
            try {
                start.runProgram();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread paperSystem = new Thread(() -> {
            try {
                start.systemReady();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        {
            powerOn.start();
            userLoggin.start();
            runWindows.start();
            runProgram.start();
            paperSystem.start();
        }

        Thread.sleep(1000);
        System.out.println("\nUser: setting time! \n");
        Thread.sleep(1000);
        start.setEnergy(true);
        Thread.sleep(1000);
        start.setLogin(true);
        Thread.sleep(1000);
        start.setAutorun(true);
        Thread.sleep(1000);
        start.setWindowRun(true);
        Thread.sleep(1000);

    }

}
