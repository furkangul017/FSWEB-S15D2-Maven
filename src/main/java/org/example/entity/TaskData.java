package org.example.entity;

import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getUnion(Set<Task>... sets){
        Set<Task> result = new HashSet<>();
        for(Set<Task> set:sets){
            result.addAll(set);
        }
        return result;
    }

    public Set<Task> getIntersection(Set<Task> set1 , Set<Task> set2){
        Set<Task> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);
         return intersect;
    }
    public Set<Task> getDifferences(Set<Task> set1 , Set<Task> set2){
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    public Set<Task> getTasks(String name){
        if(name == null) return new HashSet<>();
        if(name.equals("ann")){
            return annsTasks;
        }else if(name.equals("bob")){
            return bobsTasks;
        }else if(name.equals("carol")){
            return carolsTasks;
        }else if(name.equals("all")){
            return getUnion(annsTasks,bobsTasks,carolsTasks);
        }else {
            System.out.println("Geçerli bir isim giriniz!");
            return new HashSet<>();
        }
    }
}
