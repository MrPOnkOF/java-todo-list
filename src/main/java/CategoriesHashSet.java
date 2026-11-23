import java.util.HashSet;

/*
Метод	Что делает
add(element)	Добавляет элемент, если его ещё нет
contains(element)	Проверяет наличие
remove(element)	Удаляет элемент
size()	Возвращает количество элементов
isEmpty()	Проверяет, пуста ли коллекция
 */

public class CategoriesHashSet {

private HashSet <String> taskSet = new HashSet<>();

public void addCategory(String category){
    if (taskSet.contains(category.toLowerCase())){
        System.out.println("Category already exists");
    }else{
        taskSet.add(category.toLowerCase());
        System.out.println("Adding new category: " +  category);
    }
}
public void removeCategory(String category){
boolean removed = taskSet.remove(category.toLowerCase());
if (removed){
    System.out.println("Category: " + category + " is removed");
}else{
    System.out.println("Category: " + category + " is not found");
}
}
public void showCategories(){
    for (String category: taskSet){
        if (!category.isEmpty()){
            String result = category.substring(0, 1).toUpperCase()
                          + category.substring(1);
            System.out.println(result);
        }
    }
}

}
