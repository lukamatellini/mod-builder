# QA Test Plan: Chance Cubes

Generated: 2026-01-06T16:03:58.956Z
Minecraft Version: 1.21.1
Mod ID: chancecubes

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 43 |
| Passed | 38 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 2 |
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
| Lucky Block | `/give @p chancecubes:lucky_block_item` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p chancecubes:lucky_block` | ☐ | ☐ | ☐ |
| Mystery Block | `/give @p chancecubes:rng_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Worms | `/summon chancecubes:worm` | ☐ | ☐ | ☐ |
| Japaense Sumo Wrestlers That Attack They | `/summon chancecubes:japaense_sumo_wrestlers_that_attack_they` | ☐ | ☐ | ☐ |

### Mob Tests

#### Worms

- [ ] Spawns with `/summon chancecubes:worm`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)

#### Japaense Sumo Wrestlers That Attack They

- [ ] Spawns with `/summon chancecubes:japaense_sumo_wrestlers_that_attack_they`
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
