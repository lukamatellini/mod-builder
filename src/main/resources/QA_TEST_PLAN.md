# QA Test Plan: Cheesy Blade

Generated: 2026-01-07T14:21:22.499Z
Minecraft Version: 1.21.1
Mod ID: cheesyblade

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 47 |
| Passed | 37 |
| Failed | 5 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `cheesyblade.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Cheese Curds | `/give @p cheesyblade:cheese_curds` | ☐ | ☐ | ☐ |
| Small Cheese Block | `/give @p cheesyblade:small_cheese_block_item` | ☐ | ☐ | ☐ |
| Medium Cheese Wheel | `/give @p cheesyblade:medium_cheese_wheel_item` | ☐ | ☐ | ☐ |
| Aged Cheese Slice | `/give @p cheesyblade:aged_cheese_slice` | ☐ | ☐ | ☐ |
| Cheesemonger's Blade | `/give @p cheesyblade:cheesemongers_blade` | ☐ | ☐ | ☐ |
| Nothing If Fully Consumed | `/give @p cheesyblade:nothing_if_fully_consumed` | ☐ | ☐ | ☐ |
| Remaining Slices As Aged Cheese Slices If Partially Consumed | `/give @p cheesyblade:remaining_slices_as_aged_cheese_slices_if_partially_consumed` | ☐ | ☐ | ☐ |

### Item Tests

#### Cheese Curds

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Curds"
- [ ] Crafting recipe works

#### Small Cheese Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Small Cheese Block"
- [ ] Crafting recipe works

#### Medium Cheese Wheel

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Medium Cheese Wheel"
- [ ] Crafting recipe works

#### Aged Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aged Cheese Slice"
- [ ] Crafting recipe works

#### Cheesemonger's Blade

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheesemonger's Blade"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Nothing If Fully Consumed

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Nothing If Fully Consumed"

#### Remaining Slices As Aged Cheese Slices If Partially Consumed

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Remaining Slices As Aged Cheese Slices If Partially Consumed"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Medium Cheese Wheel Block | `/give @p cheesyblade:medium_cheese_wheel_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
