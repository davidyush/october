import java.util.*;
import java.io.*;

public class Dododo{
	public static String target;
	
	public static void main(String[] args) {
		try{
			File file = new File("/home");
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter the file you are searching for: ");
			target = sc.nextLine();	
			checking(file);
		}
		catch(IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	public static void checking(File ... path){
		for (File item : path) {
			if(!item.exists()) System.err.println("File doesn't exist");
			if(!item.canRead()) System.err.println("We cannot read the file");

			if(item.isFile()){
				if(item.getName().equals(target)){
					seccess(item);
					break;
				}
			}
			if(item.isDirectory())
				checkingDirectory(item);
		}
	}

	public static void checkingDirectory(File directory){
		File [] files = directory.listFiles();
		if(files.length != 0){	
			for (int i = 0; i < files.length; i++) {
				if(files[i].getName().equals(target)){
					seccess(files[i]);
					break;
				}
				if(files[i].isDirectory()) checking(files[i]);
				//System.out.println(files[i]);
			}
			System.out.println("");	
		}
	}

	public static void seccess(File nope){
		System.out.println("\t**********Gratz!**********");
		System.out.println("The path of the file: " + nope.getPath());
		System.out.println("Length of the file: " + nope.length() + " bytes");
		System.out.println("Last Modified " + new Date(nope.lastModified()));
		if(nope.isDirectory()){
			System.out.println("The " + nope.getName() + " contains next files:");
			File [] someFiles = nope.listFiles();
			for (File file : someFiles) {
				System.out.println(file);
			}
		}
	}

	private static void fail(String message) throws IllegalArgumentException{
		throw new IllegalArgumentException(message);
	}
}

//1.задает только файл(неважно это папка или файл). может стоит дать возможность помочь в прописи адреса?
/*
 a. проходим по всем файлам компа кроме /sys and trash
 b. ищем соответсвие, опуская расширения
 c. может быть несколько файлов с разыми расширениями, нужно чтобы выдавал все
 d. искать похожие, т.е. учитывая ошики юзера
 */
//2.показываемм ему путь к этому файлу
//3.если это папка то выдать содержание
//4.выдать инфу файла(сколько весит,когда был создат,скрытый ли файл или папка итд)
//5.дальнейшие действия(удалить/копировать/посомотреть/изменить)
//p.s. нихуЯ не хочеться делать это!