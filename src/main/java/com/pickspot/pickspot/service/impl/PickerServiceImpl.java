package com.pickspot.pickspot.service.impl;

import com.pickspot.pickspot.model.Container;
import com.pickspot.pickspot.model.Slot;
import com.pickspot.pickspot.service.PickerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PickerServiceImpl implements PickerService {

    private static final int INVALID = 10_000;

    public Optional<Slot> chooseBestSlot(Container container, List<Slot> slot) {
        Slot best = null;
        int bestScore = INVALID + 1;
        for (Slot s : slot) {
            int score = score(container, s);
            if (score < bestScore) {
                bestScore = score;
                best = s;
            }
        }
        return bestScore >= INVALID ? Optional.empty() : Optional.of(best);
    }

    private int score(Container container, Slot slot) {
        int distance = Math.abs(container.x - slot.x) + Math.abs(container.y- slot.y);
        int sizePenalty = (container.size.equals("big") && slot.sizeCap.equals("small")) ? INVALID : 0;
        int coldPenalty = (container.needsCold&& !slot.hasColdUnit) ? INVALID : 0;
        int occPenalty = slot.occupied? INVALID : 0;
        return distance + sizePenalty + coldPenalty + occPenalty;
    }
}

