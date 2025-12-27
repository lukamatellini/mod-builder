# QA Test Plan: Cheesy Blocks

Generated: 2025-12-27T13:41:49.306Z
Minecraft Version: 1.21.1
Mod ID: cheesyblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 44 |
| Passed | 38 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 3 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `cheesyblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Cheese Sword | `/give @p cheesyblocks:cheese_sword` | ☐ | ☐ | ☐ |
| Cheese Helmet | `/give @p cheesyblocks:cheese_helmet` | ☐ | ☐ | ☐ |
| Cheese Chestplate | `/give @p cheesyblocks:cheese_chestplate` | ☐ | ☐ | ☐ |
| Cheese Leggings | `/give @p cheesyblocks:cheese_leggings` | ☐ | ☐ | ☐ |
| Cheese Boots | `/give @p cheesyblocks:cheese_boots` | ☐ | ☐ | ☐ |

### Item Tests

#### Cheese Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Cheese Helmet

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Helmet"
- [ ] Crafting recipe works

#### Cheese Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Chestplate"
- [ ] Crafting recipe works

#### Cheese Leggings

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Leggings"
- [ ] Crafting recipe works

#### Cheese Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Boots"
- [ ] Crafting recipe works

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Cheese Block | `/give @p cheesyblocks:cheese_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
