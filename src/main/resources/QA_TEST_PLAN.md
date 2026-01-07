# QA Test Plan: Sumo Undead Worms

Generated: 2026-01-07T02:43:49.944Z
Minecraft Version: 1.21.1
Mod ID: sumoundeadworms

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 55 |
| Passed | 47 |
| Failed | 4 |
| Warnings | 3 |
| Skipped | 1 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `sumoundeadworms.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Sumo Hachimaki | `/give @p sumoundeadworms:sumo_hachimaki` | ☐ | ☐ | ☐ |
| Carrot Rare | `/give @p sumoundeadworms:carrot_rare` | ☐ | ☐ | ☐ |
| Clay Ball Rare | `/give @p sumoundeadworms:clay_ball_rare` | ☐ | ☐ | ☐ |
| Raw Porkchop | `/give @p sumoundeadworms:raw_porkchop` | ☐ | ☐ | ☐ |
| Sumo Hachimaki Rare Cosmetic Helmet With Protection I | `/give @p sumoundeadworms:sumo_hachimaki_rare_cosmetic_helmet_with_protection_i` | ☐ | ☐ | ☐ |

### Item Tests

#### Sumo Hachimaki

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Sumo Hachimaki"
- [ ] Crafting recipe works

#### Carrot Rare

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Carrot Rare"

#### Clay Ball Rare

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Clay Ball Rare"

#### Raw Porkchop

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Raw Porkchop"

#### Sumo Hachimaki Rare Cosmetic Helmet With Protection I

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Sumo Hachimaki Rare Cosmetic Helmet With Protection I"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Tatami Mat | `/give @p sumoundeadworms:tatami_mat` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Yokai Zombie | `/summon sumoundeadworms:yokai_zombie` | ☐ | ☐ | ☐ |
| Burrowing Worm | `/summon sumoundeadworms:burrowing_worm` | ☐ | ☐ | ☐ |
| Japanese Sumo Wrestler | `/summon sumoundeadworms:japanese_sumo_wrestler` | ☐ | ☐ | ☐ |

### Mob Tests

#### Yokai Zombie

- [ ] Spawns with `/summon sumoundeadworms:yokai_zombie`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)
  - [ ] minecraft:iron_ingot (100% chance)
  - [ ] sumoundeadworms:carrot_rare (100% chance)

#### Burrowing Worm

- [ ] Spawns with `/summon sumoundeadworms:burrowing_worm`
- [ ] Has correct health: 10
- [ ] Deals expected damage: 2
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:string (100% chance)
  - [ ] sumoundeadworms:clay_ball_rare (100% chance)

#### Japanese Sumo Wrestler

- [ ] Spawns with `/summon sumoundeadworms:japanese_sumo_wrestler`
- [ ] Has correct health: 60
- [ ] Deals expected damage: 7
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] sumoundeadworms:raw_porkchop (100% chance)
  - [ ] minecraft:leather (100% chance)
  - [ ] sumoundeadworms:sumo_hachimaki_rare_cosmetic_helmet_with_protection_i (100% chance)

## Structures Checklist

### Sumo Dojo
- [ ] Structure generates in world
- [ ] Use `/locate structure sumoundeadworms:sumo_dojo` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
