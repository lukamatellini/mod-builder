# QA Test Plan: Oceanic Riches

Generated: 2025-12-27T17:48:38.145Z
Minecraft Version: 1.21.1
Mod ID: oceanicriches

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 68 |
| Passed | 63 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 3 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `oceanicriches.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Raw Aquamarine | `/give @p oceanicriches:raw_aquamarine` | ☐ | ☐ | ☐ |
| Aquamarine Gem | `/give @p oceanicriches:aquamarine_gem` | ☐ | ☐ | ☐ |
| Aquamarine Ingot | `/give @p oceanicriches:aquamarine_ingot` | ☐ | ☐ | ☐ |
| Aquamarine Pickaxe | `/give @p oceanicriches:aquamarine_pickaxe` | ☐ | ☐ | ☐ |
| Aquamarine Axe | `/give @p oceanicriches:aquamarine_axe` | ☐ | ☐ | ☐ |
| Aquamarine Shovel | `/give @p oceanicriches:aquamarine_shovel` | ☐ | ☐ | ☐ |
| Aquamarine Sword | `/give @p oceanicriches:aquamarine_sword` | ☐ | ☐ | ☐ |
| Aquamarine Hoe | `/give @p oceanicriches:aquamarine_hoe` | ☐ | ☐ | ☐ |
| Aquamarine Helmet | `/give @p oceanicriches:aquamarine_helmet` | ☐ | ☐ | ☐ |
| Aquamarine Chestplate | `/give @p oceanicriches:aquamarine_chestplate` | ☐ | ☐ | ☐ |
| Aquamarine Leggings | `/give @p oceanicriches:aquamarine_leggings` | ☐ | ☐ | ☐ |
| Aquamarine Boots | `/give @p oceanicriches:aquamarine_boots` | ☐ | ☐ | ☐ |

### Item Tests

#### Raw Aquamarine

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Raw Aquamarine"
- [ ] Crafting recipe works

#### Aquamarine Gem

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Gem"
- [ ] Crafting recipe works

#### Aquamarine Ingot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Ingot"
- [ ] Crafting recipe works

#### Aquamarine Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Aquamarine Axe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Axe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Aquamarine Shovel

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Shovel"
- [ ] Crafting recipe works

#### Aquamarine Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Aquamarine Hoe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Hoe"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

#### Aquamarine Helmet

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Helmet"
- [ ] Crafting recipe works

#### Aquamarine Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Chestplate"
- [ ] Crafting recipe works

#### Aquamarine Leggings

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Leggings"
- [ ] Crafting recipe works

#### Aquamarine Boots

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aquamarine Boots"
- [ ] Crafting recipe works

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Aquamarine Ore | `/give @p oceanicriches:aquamarine_ore` | ☐ | ☐ | ☐ |

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
