# QA Test Plan: Lucky Loot Blocks

Generated: 2026-01-07T01:38:58.634Z
Minecraft Version: 1.21.1
Mod ID: luckylootblocks

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 51 |
| Passed | 40 |
| Failed | 6 |
| Warnings | 3 |
| Skipped | 2 |
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
| Lucky Block | `/give @p luckylootblocks:lucky_block_item` | ☐ | ☐ | ☐ |
| Good Drops | `/give @p luckylootblocks:good_drops` | ☐ | ☐ | ☐ |
| Random Events | `/give @p luckylootblocks:random_events` | ☐ | ☐ | ☐ |

### Item Tests

#### Lucky Block

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lucky Block"
- [ ] Crafting recipe works

#### Good Drops

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Good Drops"

#### Random Events

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Random Events"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckylootblocks:lucky_block` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Lucky Zombie | `/summon luckylootblocks:lucky_zombie` | ☐ | ☐ | ☐ |
| Lucky Spider | `/summon luckylootblocks:lucky_spider` | ☐ | ☐ | ☐ |
| Lucky Creeper | `/summon luckylootblocks:lucky_creeper` | ☐ | ☐ | ☐ |
| Lucky Cave Spider | `/summon luckylootblocks:lucky_cave_spider` | ☐ | ☐ | ☐ |

### Mob Tests

#### Lucky Zombie

- [ ] Spawns with `/summon luckylootblocks:lucky_zombie`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 3
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:rotten_flesh (100% chance)

#### Lucky Spider

- [ ] Spawns with `/summon luckylootblocks:lucky_spider`
- [ ] Has correct health: 16
- [ ] Deals expected damage: 2
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:string (100% chance)
  - [ ] minecraft:spider_eye (100% chance)

#### Lucky Creeper

- [ ] Spawns with `/summon luckylootblocks:lucky_creeper`
- [ ] Has correct health: 20
- [ ] Deals expected damage: 0
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:gunpowder (100% chance)

#### Lucky Cave Spider

- [ ] Spawns with `/summon luckylootblocks:lucky_cave_spider`
- [ ] Has correct health: 12
- [ ] Deals expected damage: 2
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] minecraft:string (100% chance)
  - [ ] minecraft:spider_eye (100% chance)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
