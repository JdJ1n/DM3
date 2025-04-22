// com/travel/manager/CompanyManager.java
package com.travel.manager;

import com.travel.model.company.Company;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompanyManager implements EntityManager<Company> {
    private static final CompanyManager INSTANCE = new CompanyManager();
    private final List<Company> items = new ArrayList<>();

    private CompanyManager() {}
    public static CompanyManager getInstance() { return INSTANCE; }

    @Override
    public void add(Company c) {
        items.add(c);
    }

    @Override
    public void edit(Company c) { }

    @Override
    public void delete(Company c) {
        items.remove(c);
    }

    @Override
    public List<Company> getAll() {
        return Collections.unmodifiableList(items);
    }
}
