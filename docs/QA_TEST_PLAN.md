# QA Test Plan: Surprise Blocks

Generated: 2026-01-06T16:29:43.290Z
Minecraft Version: 1.21.1
Mod ID: surpriseblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 61 |
| Passed | 56 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 2 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `surpriseblocks.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Pickaxe | `/give @p surpriseblocks:lucky_pickaxe` | ☐ | ☐ | ☐ |
| Lucky Sword | `/give @p surpriseblocks:lucky_sword` | ☐ | ☐ | ☐ |
| Dirt | `/give @p surpriseblocks:dirt` | ☐ | ☐ | ☐ |
| Oak Planks | `/give @p surpriseblocks:oak_planks` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Pickaxe

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Pickaxe"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Lucky Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Dirt

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Dirt"

#### Oak Planks

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Oak Planks"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p surpriseblocks:lucky_block` | ☐ | ☐ | ☐ |
| Mystery Block | `/give @p surpriseblocks:rng_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Unlucky Goblin | `/summon surpriseblocks:unlucky_goblin` | ☐ | ☐ | ☐ |
| Worms | `/summon surpriseblocks:worm` | ☐ | ☐ | ☐ |
| Japanese Sumo Wrestlers That Attack Till Kill Them | `/summon surpriseblocks:japanese_sumo_wrestlers_that_attack_till_kill_them` | ☐ | ☐ | ☐ |

### Mob Tests

#### Unlucky Goblin

- [ ] Spawns with `/summon surpriseblocks:unlucky_goblin`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 5
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:gold_ingot (100% chance)
  - [ ] minecraft:gold_ingot (100% chance)
  - [ ] minecraft:gold_ingot (100% chance)
  - [ ] surpriseblocks:lucky_block (100% chance)

#### Worms

- [ ] Spawns with `/summon surpriseblocks:worm`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)

#### Japanese Sumo Wrestlers That Attack Till Kill Them

- [ ] Spawns with `/summon surpriseblocks:japanese_sumo_wrestlers_that_attack_till_kill_them`
- [ ] Has correct health: 30
- [ ] Deals expected damage: 5
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
