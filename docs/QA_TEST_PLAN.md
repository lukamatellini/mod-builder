# QA Test Plan: Fortunes Folly

Generated: 2026-01-06T15:43:51.951Z
Minecraft Version: 1.21.1
Mod ID: fortunesfolly

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 67 |
| Passed | 62 |
| Failed | 0 |
| Warnings | 3 |
| Skipped | 2 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `fortunesfolly.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Lucky Block | `/give @p fortunesfolly:lucky_block` | ☐ | ☐ | ☐ |
| Minecraftfeather | `/give @p fortunesfolly:minecraftfeather` | ☐ | ☐ | ☐ |
| Minecraftegg | `/give @p fortunesfolly:minecraftegg` | ☐ | ☐ | ☐ |
| Minecraftporkchop | `/give @p fortunesfolly:minecraftporkchop` | ☐ | ☐ | ☐ |
| Minecraftsaddle | `/give @p fortunesfolly:minecraftsaddle` | ☐ | ☐ | ☐ |
| Dirt | `/give @p fortunesfolly:dirt` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Minecraftfeather

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftfeather"

#### Minecraftegg

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftegg"

#### Minecraftporkchop

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftporkchop"

#### Minecraftsaddle

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftsaddle"

#### Dirt

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Dirt"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p fortunesfolly:lucky_block` | ☐ | ☐ | ☐ |
| Mystery Block | `/give @p fortunesfolly:rng_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Lucky Chicken | `/summon fortunesfolly:lucky_chicken` | ☐ | ☐ | ☐ |
| Lucky Pig | `/summon fortunesfolly:lucky_pig` | ☐ | ☐ | ☐ |
| Japanese Sumo Wrestelrs | `/summon fortunesfolly:japanese_sumo_wrestelrs` | ☐ | ☐ | ☐ |
| Worms Spawn. | `/summon fortunesfolly:worms_spawn` | ☐ | ☐ | ☐ |

### Mob Tests

#### Lucky Chicken

- [ ] Spawns with `/summon fortunesfolly:lucky_chicken`
- [ ] Has correct health: 10
- [ ] Deals expected damage: 5
- [ ] AI behavior works (passive)
- [ ] Drops loot on death:
  - [ ] fortunesfolly:minecraftfeather (100% chance)
  - [ ] fortunesfolly:minecraftegg (100% chance)

#### Lucky Pig

- [ ] Spawns with `/summon fortunesfolly:lucky_pig`
- [ ] Has correct health: 10
- [ ] Deals expected damage: 5
- [ ] AI behavior works (passive)
- [ ] Drops loot on death:
  - [ ] fortunesfolly:minecraftporkchop (100% chance)
  - [ ] fortunesfolly:minecraftsaddle (100% chance)

#### Japanese Sumo Wrestelrs

- [ ] Spawns with `/summon fortunesfolly:japanese_sumo_wrestelrs`
- [ ] Has correct health: 30
- [ ] Deals expected damage: 5
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)

#### Worms Spawn.

- [ ] Spawns with `/summon fortunesfolly:worms_spawn`
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
