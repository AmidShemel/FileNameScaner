import java.io.File;


/**
 * Утиліта сканує цільову директорію на наявність файлів, фільтрує нумерацію у назвах і створює
 * файл з наступним порядковим номером приписуючи букву О на початку назви нового файлу
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(setNextFileName());

    }

    private static String setNextFileName() {

        File folder = new File("C:\\Users\\vb\\Desktop\\P");
        File[] listOfFiles = folder.listFiles();
        String fileName;
        int j, k = 0;

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                j = Integer.valueOf(listOfFiles[i].getName().toUpperCase().replaceAll("[^0-9]", ""));
                if(j>999) j = 0;
                if(k<j) k = j;
            } else if (listOfFiles[i].isDirectory()) {
                //System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        fileName = String.format("O%04d", k + 1);
        return fileName;
    }

}
