package br.com.formula.bancaria.api.dto.base;

import java.util.List;

public class SimpleViewModelCollectionDTO {
    private List<SimpleViewModelDTO> items;

    public SimpleViewModelCollectionDTO(List<SimpleViewModelDTO> items)
    {
        this.items = items;
    }

    public List<SimpleViewModelDTO> getItems() {
        return items;
    }

    public void setItems(List<SimpleViewModelDTO> items) {
        this.items = items;
    }
}