# QA Test Plan: Strength I

Generated: 2025-12-28T00:24:38.927Z
Minecraft Version: 1.21.1
Mod ID: strengthi

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 58 |
| Passed | 52 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 3 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `strengthi.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Cheese Slice | `/give @p strengthi:cheese_slice` | ☐ | ☐ | ☐ |
| Melted Cheese | `/give @p strengthi:melted_cheese` | ☐ | ☐ | ☐ |
| Aged Cheese | `/give @p strengthi:aged_cheese` | ☐ | ☐ | ☐ |
| Cheese Pickaxe | `/give @p strengthi:cheese_pickaxe` | ☐ | ☐ | ☐ |
| Cheese Sword | `/give @p strengthi:cheese_sword` | ☐ | ☐ | ☐ |
| Cheese Helmet | `/give @p strengthi:cheese_helmet` | ☐ | ☐ | ☐ |
| Cheese Chestplate | `/give @p strengthi:cheese_chestplate` | ☐ | ☐ | ☐ |
| Cheese Leggings | `/give @p strengthi:cheese_leggings` | ☐ | ☐ | ☐ |
| Cheese Boots | `/give @p strengthi:cheese_boots` | ☐ | ☐ | ☐ |

### Item Tests

#### Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Slice"
- [ ] Crafting recipe works

#### Melted Cheese

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Melted Cheese"
- [ ] Crafting recipe works

#### Aged Cheese

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aged Cheese"
- [ ] Crafting recipe works

#### Cheese Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

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
| Cheese Block | `/give @p strengthi:cheese_block` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
