# QA Test Plan: CheesyCraft

Generated: 2026-01-12T12:39:06.948Z
Minecraft Version: 1.21.1
Mod ID: cheesycraft

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 90 |
| Passed | 74 |
| Failed | 12 |
| Warnings | 3 |
| Skipped | 1 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `cheesycraft.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Cheese Slice | `/give @p cheesycraft:cheese_slice` | ☐ | ☐ | ☐ |
| Cheese Sword | `/give @p cheesycraft:cheese_sword` | ☐ | ☐ | ☐ |
| Cheese Pickaxe | `/give @p cheesycraft:cheese_pickaxe` | ☐ | ☐ | ☐ |
| Cheese Axe | `/give @p cheesycraft:cheese_axe` | ☐ | ☐ | ☐ |
| Cheese Helmet | `/give @p cheesycraft:cheese_helmet` | ☐ | ☐ | ☐ |
| Cheese Chestplate | `/give @p cheesycraft:cheese_chestplate` | ☐ | ☐ | ☐ |
| Cheese Leggings | `/give @p cheesycraft:cheese_leggings` | ☐ | ☐ | ☐ |
| Cheese Boots | `/give @p cheesycraft:cheese_boots` | ☐ | ☐ | ☐ |
| Mouse Trap | `/give @p cheesycraft:mouse_trap` | ☐ | ☐ | ☐ |
| Common Cheese Slice | `/give @p cheesycraft:common_cheese_slice` | ☐ | ☐ | ☐ |
| Rare String | `/give @p cheesycraft:rare_string` | ☐ | ☐ | ☐ |
| Rare Poison Gland | `/give @p cheesycraft:rare_poison_gland` | ☐ | ☐ | ☐ |
| Epic Cheese Block | `/give @p cheesycraft:epic_cheese_block` | ☐ | ☐ | ☐ |

### Item Tests

#### Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Slice"
- [ ] Crafting recipe works

#### Cheese Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Cheese Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Cheese Axe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Axe"
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

#### Mouse Trap

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Mouse Trap"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Common Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Common Cheese Slice"

#### Rare String

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Rare String"

#### Rare Poison Gland

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Rare Poison Gland"

#### Epic Cheese Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Epic Cheese Block"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Cheese Block | `/give @p cheesycraft:cheese_block` | ☐ | ☐ | ☐ |
| Aged Cheese Block | `/give @p cheesycraft:aged_cheese_block` | ☐ | ☐ | ☐ |
| Cheese Ore | `/give @p cheesycraft:cheese_ore` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Mouse | `/summon cheesycraft:mouse` | ☐ | ☐ | ☐ |
| Rat | `/summon cheesycraft:rat` | ☐ | ☐ | ☐ |
| Cheesy Golem | `/summon cheesycraft:cheesy_golem` | ☐ | ☐ | ☐ |

### Mob Tests

#### Mouse

- [ ] Spawns with `/summon cheesycraft:mouse`
- [ ] Has correct health: 8
- [ ] Deals expected damage: 1
- [ ] AI behavior works (passive)
- [ ] Drops loot on death:
  - [ ] cheesycraft:common_cheese_slice (100% chance)
  - [ ] cheesycraft:rare_string (100% chance)

#### Rat

- [ ] Spawns with `/summon cheesycraft:rat`
- [ ] Has correct health: 12
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] cheesycraft:common_cheese_slice (100% chance)
  - [ ] cheesycraft:rare_poison_gland (100% chance)

#### Cheesy Golem

- [ ] Spawns with `/summon cheesycraft:cheesy_golem`
- [ ] Has correct health: 60
- [ ] Deals expected damage: 10
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] cheesycraft:epic_cheese_block (100% chance)
  - [ ] minecraft:gold_ingot (100% chance)

## Structures Checklist

### Cheese Dungeon
- [ ] Structure generates in world
- [ ] Use `/locate structure cheesycraft:cheese_dungeon` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
