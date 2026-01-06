# QA Test Plan: Chance Cubes

Generated: 2026-01-06T15:33:04.893Z
Minecraft Version: 1.21.1
Mod ID: chancecubes

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 64 |
| Passed | 60 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 1 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `chancecubes.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Pickaxe | `/give @p chancecubes:lucky_pickaxe` | ☐ | ☐ | ☐ |
| Lucky Sword | `/give @p chancecubes:lucky_sword` | ☐ | ☐ | ☐ |
| A.I.D. Heart | `/give @p chancecubes:a_i_d_heart` | ☐ | ☐ | ☐ |
| Rotten Flesh | `/give @p chancecubes:rotten_flesh` | ☐ | ☐ | ☐ |
| Aid Heart | `/give @p chancecubes:aid_heart` | ☐ | ☐ | ☐ |
| Spider Eye | `/give @p chancecubes:spider_eye` | ☐ | ☐ | ☐ |

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

#### A.I.D. Heart

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "A.I.D. Heart"
- [ ] Crafting recipe works

#### Rotten Flesh

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Rotten Flesh"

#### Aid Heart

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Aid Heart"

#### Spider Eye

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Spider Eye"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p chancecubes:lucky_block` | ☐ | ☐ | ☐ |
| Unlucky Block | `/give @p chancecubes:unlucky_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Lucky Goblin | `/summon chancecubes:lucky_goblin` | ☐ | ☐ | ☐ |
| Unlucky Zombie | `/summon chancecubes:unlucky_zombie` | ☐ | ☐ | ☐ |

### Mob Tests

#### Lucky Goblin

- [ ] Spawns with `/summon chancecubes:lucky_goblin`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 5
- [ ] AI behavior works (neutral)
- [ ] Drops loot on death:
  - [ ] minecraft:gold_ingot (100% chance)
  - [ ] minecraft:emerald (100% chance)

#### Unlucky Zombie

- [ ] Spawns with `/summon chancecubes:unlucky_zombie`
- [ ] Has correct health: 30
- [ ] Deals expected damage: 7
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)
  - [ ] minecraft:bone (100% chance)
  - [ ] chancecubes:aid_heart (100% chance)

## Structures Checklist

### Lucky Shrine
- [ ] Structure generates in world
- [ ] Use `/locate structure chancecubes:lucky_shrine` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
