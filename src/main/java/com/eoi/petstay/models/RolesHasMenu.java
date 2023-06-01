package com.eoi.petstay.models;

import jakarta.persistence.*;


@Entity
@Table(name = "roles_has_menu")
public class RolesHasMenu {
    @OneToMany
    @JoinColumn(name = "rol_id")
    private Roles rolID;

    @OneToMany
    @JoinColumn(name = "menu_id")
    private Menu menuID;

    public Roles getRolID() {
        return rolID;
    }

    public void setRolID(Roles rolID) {
        this.rolID = rolID;
    }

    public Menu getMenuID() {
        return menuID;
    }

    public void setMenuID(Menu menuID) {
        this.menuID = menuID;
    }
}
