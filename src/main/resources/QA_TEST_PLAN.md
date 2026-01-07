# QA Test Plan: Cheesy Blade

Generated: 2026-01-07T14:19:42.254Z
Minecraft Version: 1.21.1
Mod ID: cheesyblade

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 82 |
| Passed | 69 |
| Failed | 10 |
| Warnings | 2 |
| Skipped | 1 |
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
| Cheese Sword | `/give @p cheesyblade:cheese_sword` | ☐ | ☐ | ☐ |
| Cheese Slice | `/give @p cheesyblade:cheese_slice` | ☐ | ☐ | ☐ |
| Moldy Cheese | `/give @p cheesyblade:moldy_cheese` | ☐ | ☐ | ☐ |
| Cheese Curds | `/give @p cheesyblade:cheese_curds` | ☐ | ☐ | ☐ |
| Cheese Helmet | `/give @p cheesyblade:cheese_armor_helmet` | ☐ | ☐ | ☐ |
| Cheese Chestplate | `/give @p cheesyblade:cheese_armor_chestplate` | ☐ | ☐ | ☐ |
| Cheese Leggings | `/give @p cheesyblade:cheese_armor_leggings` | ☐ | ☐ | ☐ |
| Cheese Boots | `/give @p cheesyblade:cheese_armor_boots` | ☐ | ☐ | ☐ |
| X Cheese Slice | `/give @p cheesyblade:x_cheese_slice` | ☐ | ☐ | ☐ |
| X Cheese Block | `/give @p cheesyblade:x_cheese_block` | ☐ | ☐ | ☐ |
| 1x Moldy Cheese | `/give @p cheesyblade:1x_moldy_cheese` | ☐ | ☐ | ☐ |
| X Moldy Cheese | `/give @p cheesyblade:x_moldy_cheese` | ☐ | ☐ | ☐ |
| X Cheese Curds Smelts Into Cheese Curds | `/give @p cheesyblade:x_cheese_curds_smelts_into_cheese_curds` | ☐ | ☐ | ☐ |

### Item Tests

#### Cheese Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Slice"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Moldy Cheese

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Moldy Cheese"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Cheese Curds

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Curds"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

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

#### X Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "X Cheese Slice"

#### X Cheese Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "X Cheese Block"

#### 1x Moldy Cheese

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "1x Moldy Cheese"

#### X Moldy Cheese

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "X Moldy Cheese"

#### X Cheese Curds Smelts Into Cheese Curds

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "X Cheese Curds Smelts Into Cheese Curds"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Cheese Block | `/give @p cheesyblade:cheese_block` | ☐ | ☐ | ☐ |
| Aged Cheese Block | `/give @p cheesyblade:aged_cheese_block` | ☐ | ☐ | ☐ |
| Cheese Ore | `/give @p cheesyblade:cheese_ore` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Cheese Golem | `/summon cheesyblade:cheese_golem` | ☐ | ☐ | ☐ |
| Hungry Mouse | `/summon cheesyblade:hungry_mouse` | ☐ | ☐ | ☐ |

### Mob Tests

#### Cheese Golem

- [ ] Spawns with `/summon cheesyblade:cheese_golem`
- [ ] Has correct health: 40
- [ ] Deals expected damage: 8
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] cheesyblade:x_cheese_slice (100% chance)
  - [ ] cheesyblade:x_cheese_block (100% chance)

#### Hungry Mouse

- [ ] Spawns with `/summon cheesyblade:hungry_mouse`
- [ ] Has correct health: 10
- [ ] Deals expected damage: 2
- [ ] AI behavior works (passive)
- [ ] Drops loot on death:
  - [ ] cheesyblade:1x_moldy_cheese (100% chance)

## Structures Checklist

### Cheese Mine
- [ ] Structure generates in world
- [ ] Use `/locate structure cheesyblade:cheese_mine` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
