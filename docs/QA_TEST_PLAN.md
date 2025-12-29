# QA Test Plan: Lucky Block

Generated: 2025-12-29T06:05:24.802Z
Minecraft Version: 1.21.1
Mod ID: luckyblock

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 48 |
| Passed | 43 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 2 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckyblock.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Rotten Flesh | `/give @p luckyblock:rotten_flesh` | ☐ | ☐ | ☐ |
| Carrot | `/give @p luckyblock:carrot` | ☐ | ☐ | ☐ |
| Potato | `/give @p luckyblock:potato` | ☐ | ☐ | ☐ |
| Randomly Drops Items From A Defined Loot Pool Or Spawns A Hostile Zombie | `/give @p luckyblock:randomly_drops_items_from_a_defined_loot_pool_or_spawns_a_hostile_zombie` | ☐ | ☐ | ☐ |
| Refined Ingot | `/give @p luckyblock:refined_ingot` | ☐ | ☐ | ☐ |

### Item Tests

#### Rotten Flesh

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Rotten Flesh"
- [ ] Crafting recipe works

#### Carrot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Carrot"
- [ ] Crafting recipe works

#### Potato

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Potato"
- [ ] Crafting recipe works

#### Randomly Drops Items From A Defined Loot Pool Or Spawns A Hostile Zombie

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Randomly Drops Items From A Defined Loot Pool Or Spawns A Hostile Zombie"
- [ ] Crafting recipe works

#### Refined Ingot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Refined Ingot"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckyblock:lucky_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Lucky Zombie | `/summon luckyblock:lucky_zombie` | ☐ | ☐ | ☐ |

### Mob Tests

#### Lucky Zombie

- [ ] Spawns with `/summon luckyblock:lucky_zombie`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)
  - [ ] minecraft:iron_ingot (100% chance)
  - [ ] minecraft:carrot (100% chance)
  - [ ] minecraft:potato (100% chance)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
