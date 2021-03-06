package seedu.duke.module;

import seedu.duke.storage.Storage;

import java.util.ArrayList;
import java.util.Collections;

public class ModuleList {

    private ArrayList<String> modules;
    private static Module selectedModule;

    public ModuleList() {
        this.modules = new ArrayList<>();
    }

    public ArrayList<String> getModules() {
        return modules;
    }

    public void setModules(ArrayList<String> modules) {
        this.modules = modules;
    }

    public String addModule(String moduleCode) {
        modules.add(moduleCode);
        return moduleCode;
    }

    public ArrayList<String> deleteModules(ArrayList<Integer> moduleNumbers) {
        ArrayList<String> deletedModules = new ArrayList<>();
        Collections.reverse(moduleNumbers);
        for (Integer moduleNumber : moduleNumbers) {
            int indexToRemove = moduleNumber - 1;
            deletedModules.add(0, modules.remove(indexToRemove));
        }
        return deletedModules;
    }

    public static Module getSelectedModule() {
        return selectedModule;
    }

    public static void setSelectedModule(String name) {
        //selectedModule = storage.loadModule(name);
    }

    public static void reset() {
        selectedModule = null;
    }
}
