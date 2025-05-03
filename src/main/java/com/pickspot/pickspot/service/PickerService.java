package com.pickspot.pickspot.service;

import com.pickspot.pickspot.model.Container;
import com.pickspot.pickspot.model.Slot;

import java.util.List;
import java.util.Optional;

public interface PickerService {
    public Optional<Slot> chooseBestSlot(Container container, List<Slot> slots);

}
