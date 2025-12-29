# QA Test Plan: Lucky Block

Generated: 2025-12-29T11:12:51.542Z
Minecraft Version: 1.21.1
Mod ID: luckyblock

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 48 |
| Passed | 44 |
| Failed | 0 |
| Warnings | 2 |
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
| Worm Scale | `/give @p luckyblock:worm_scale` | ☐ | ☐ | ☐ |
| Worm Scales | `/give @p luckyblock:worm_scales` | ☐ | ☐ | ☐ |
| Minecraftslime Ball | `/give @p luckyblock:minecraftslime_ball` | ☐ | ☐ | ☐ |
| Refined Ingot | `/give @p luckyblock:refined_ingot` | ☐ | ☐ | ☐ |

### Item Tests

#### Worm Scale

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Worm Scale"
- [ ] Crafting recipe works

#### Worm Scales

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Worm Scales"
- [ ] Crafting recipe works

#### Minecraftslime Ball

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftslime Ball"
- [ ] Crafting recipe works

#### Refined Ingot

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Refined Ingot"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Lucky Block | `/give @p luckyblock:lucky_block` | ☐ | ☐ | ☐ |
| Minecraftstone | `/give @p luckyblock:minecraftstone` | ☐ | ☐ | ☐ |

## Mobs Checklist

| Mob | Summon Command | Spawns | AI | Drops |
|-----|----------------|--------|-----|-------|
| Giant Worm | `/summon luckyblock:giant_worm` | ☐ | ☐ | ☐ |

### Mob Tests

#### Giant Worm

- [ ] Spawns with `/summon luckyblock:giant_worm`
- [ ] Has correct health: 60
- [ ] Deals expected damage: 8
- [ ] AI behavior works (hostile)
- [ ] Drops loot on death:
  - [ ] luckyblock:worm_scales (100% chance)
  - [ ] luckyblock:minecraftslime_ball (100% chance)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
