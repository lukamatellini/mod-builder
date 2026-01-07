# QA Test Plan: Lucky Loot Blocks

Generated: 2026-01-07T04:36:35.881Z
Minecraft Version: 1.21.1
Mod ID: luckylootblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 88 |
| Passed | 67 |
| Failed | 17 |
| Warnings | 3 |
| Skipped | 1 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `luckylootblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Stone Pickaxe | `/give @p luckylootblocks:stone_pickaxe` | ☐ | ☐ | ☐ |
| Bread | `/give @p luckylootblocks:bread` | ☐ | ☐ | ☐ |
| Cooked Beef | `/give @p luckylootblocks:cooked_beef` | ☐ | ☐ | ☐ |
| Apple | `/give @p luckylootblocks:apple` | ☐ | ☐ | ☐ |
| Golden Apple | `/give @p luckylootblocks:golden_apple` | ☐ | ☐ | ☐ |
| Enchanted Book | `/give @p luckylootblocks:enchanted_book` | ☐ | ☐ | ☐ |
| Iron Chestplate | `/give @p luckylootblocks:iron_chestplate` | ☐ | ☐ | ☐ |
| Netherite Scrap | `/give @p luckylootblocks:netherite_scrap` | ☐ | ☐ | ☐ |
| Ancient Debris | `/give @p luckylootblocks:ancient_debris` | ☐ | ☐ | ☐ |
| Dragon's Breath | `/give @p luckylootblocks:dragon_breath` | ☐ | ☐ | ☐ |
| Diamond Sword (Sharpness I) | `/give @p luckylootblocks:diamond_sword_sharpness_1` | ☐ | ☐ | ☐ |
| Bow (Power I) | `/give @p luckylootblocks:bow_power_1` | ☐ | ☐ | ☐ |
| Diamond Chestplate (Protection II) | `/give @p luckylootblocks:diamond_chestplate_protection_2` | ☐ | ☐ | ☐ |
| Efficiency III Pickaxe | `/give @p luckylootblocks:efficiency_3_pickaxe` | ☐ | ☐ | ☐ |
| Lucky Block | `/give @p luckylootblocks:lucky_block_item` | ☐ | ☐ | ☐ |

### Item Tests

#### Stone Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Stone Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Bread

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Bread"
- [ ] Crafting recipe works

#### Cooked Beef

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cooked Beef"
- [ ] Crafting recipe works

#### Apple

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Apple"
- [ ] Crafting recipe works

#### Golden Apple

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Golden Apple"
- [ ] Crafting recipe works

#### Enchanted Book

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Enchanted Book"
- [ ] Crafting recipe works

#### Iron Chestplate

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Iron Chestplate"
- [ ] Crafting recipe works

#### Netherite Scrap

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Netherite Scrap"
- [ ] Crafting recipe works

#### Ancient Debris

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Ancient Debris"
- [ ] Crafting recipe works

#### Dragon's Breath

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Dragon's Breath"
- [ ] Crafting recipe works

#### Diamond Sword (Sharpness I)

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Sword (Sharpness I)"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Bow (Power I)

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Bow (Power I)"
- [ ] Crafting recipe works

#### Diamond Chestplate (Protection II)

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Diamond Chestplate (Protection II)"
- [ ] Crafting recipe works

#### Efficiency III Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Efficiency III Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckylootblocks:lucky_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Reinforced Zombie | `/summon luckylootblocks:reinforced_zombie` | ☐ | ☐ | ☐ |
| Reinforced Skeleton | `/summon luckylootblocks:reinforced_skeleton` | ☐ | ☐ | ☐ |

### Mob Tests

#### Reinforced Zombie

- [ ] Spawns with `/summon luckylootblocks:reinforced_zombie`
- [ ] Has correct health: 40
- [ ] Deals expected damage: 8
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)
  - [ ] minecraft:iron_ingot (100% chance)

#### Reinforced Skeleton

- [ ] Spawns with `/summon luckylootblocks:reinforced_skeleton`
- [ ] Has correct health: 30
- [ ] Deals expected damage: 6
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:bone (100% chance)
  - [ ] minecraft:arrow (100% chance)
  - [ ] minecraft:iron_ingot (100% chance)

## Structures Checklist

### Valuable Loot Chest
- [ ] Structure generates in world
- [ ] Use `/locate structure luckylootblocks:valuable_loot_chest_structure` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
